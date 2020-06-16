package com.netty.fuse;

import java.util.LinkedList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.component.netty4.NettyConstants;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.group.ChannelGroup;
import org.jboss.netty.channel.group.DefaultChannelGroup;

public class TcpConnection {
	ChannelGroup allConnected = new DefaultChannelGroup("all-connected");
	private List<String> messageStore = new LinkedList<>();
	private Channel openedChannel;

	public void sendToTCP(String message) {
		System.out.println("====== SEND MESSAGE TO NETTY OPENED CHANNEL ======");
		System.out.println("[Service] - Sending Message over TCP Channel :" + message);

		System.out.println("[Service] - Channel is Connected? :" + this.openedChannel.isConnected());
		System.out.println("[Service] - Channel is Open? :" + this.openedChannel.isOpen());
		System.out.println("[Service] - Channel is Writeble? :" + this.openedChannel.isWritable());
		this.openedChannel.write(message);

	}

	public void channelConnected(String input, ChannelHandlerContext ctx, ChannelStateEvent e,Exchange exchange) throws Exception {
		allConnected.add(exchange.getIn().getHeader(NettyConstants.NETTY_CHANNEL, Channel.class));
		System.out.println("Channel :" + allConnected.getName());
	}

	public void receiveFromTCP(String input, Exchange exchange) {
		System.out.println("====== INITIATE NETTY OPENED CHANNEL ======");
		this.openedChannel = exchange.getProperty(NettyConstants.NETTY_CHANNEL, Channel.class);
		final String messageFromTcp = exchange.getIn().getBody(String.class);
		System.out.println("[Service] - Channel is Connected? :" + this.openedChannel.isConnected());
		System.out.println("[Service] - Channel is Open? :" + this.openedChannel.isOpen());
		System.out.println("[Service] - Channel is Writeble? :" + this.openedChannel.isWritable());
		System.out.println("[Service] - Message from Tcp :" + messageFromTcp);
		this.messageStore.add(messageFromTcp);
	}
}
