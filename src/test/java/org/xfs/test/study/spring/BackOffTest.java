package org.xfs.test.study.spring;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.util.backoff.BackOff;
import org.springframework.util.backoff.BackOffExecution;
import org.springframework.util.backoff.ExponentialBackOff;
import org.springframework.util.backoff.FixedBackOff;

/**
 * 退避实现（比如网络连接失败后延迟多久重试）
 * 
 * @author Jeken.Liu
 *
 */
@SuppressWarnings("deprecation")
public class BackOffTest {
    // @Test
    public void testFixedBackOff() {
        long interval = 1000;
        long maxAttempts = 10;
        BackOff backOff = new FixedBackOff(interval, maxAttempts);
        BackOffExecution execution = backOff.start();
        for (int i = 1; i <= 10; i++) {
            // 每次重试时间是100毫秒
            long time = execution.nextBackOff();
            System.out.println(time);
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        Assert.assertEquals(BackOffExecution.STOP, execution.nextBackOff());

    }



    @Test
    public void testExponentialBackOff() {
        long initialInterval = 100;// 初始间隔
        long maxInterval = 50000 * 1000L;// 最大间隔
        long maxElapsedTime = 550000 * 1000L;// 最大时间间隔
        double multiplier = 2;// 递增倍数（即下次间隔是上次的多少倍）
        ExponentialBackOff backOff = new ExponentialBackOff(initialInterval, multiplier);
        backOff.setMaxInterval(maxInterval);
        // currentElapsedTime = interval1 + interval2 + ... + intervalN;
        backOff.setMaxElapsedTime(maxElapsedTime);

        BackOffExecution execution = backOff.start();

        for (int i = 1; i <= 18; i++) {
            System.out.println(execution.nextBackOff());
        }
        // Assert.assertEquals(BackOffExecution.STOP, execution.nextBackOff());
    }
}
