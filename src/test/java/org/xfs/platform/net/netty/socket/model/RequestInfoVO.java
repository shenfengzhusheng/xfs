package org.xfs.platform.net.netty.socket.model;

public class RequestInfoVO {

    private int protocol=0X1243162D;//4个字节
    private String requestId;//32位
    private byte version=1;//1b
    private byte type;//1b
    private int clientId;//4字节
    private int length;//4字节
    /**32 **/
    private String body;
    private int sequence;//4字节
	public int getProtocol() {
		return protocol;
	}
	public void setProtocol(int protocol) {
		this.protocol = protocol;
	}
	
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public byte getVersion() {
		return version;
	}
	public void setVersion(byte version) {
		this.version = version;
	}
	public byte getType() {
		return type;
	}
	public void setType(byte type) {
		this.type = type;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	@Override
	public String toString() {
		return "RequestInfoVO [protocol=" + protocol + ", requestId=" + requestId + ", version=" + version + ", type="
				+ type + ", clientId=" + clientId + ", length=" + length + ", body=" + body + ", sequence=" + sequence
				+ "]";
	}
	

   
    
}
