package io.netty_definitive_guide.chapter5;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class EchoServerHandler extends ChannelHandlerAdapter {
    int counter = 0;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        // String body = (String) msg;
        // System.out.println("this is " + ++counter + " times receive client :[" + body + "]");
        //
        // body += "$_";
        // ByteBuf echo = Unpooled.copiedBuffer(body.getBytes());
        // ctx.writeAndFlush(echo);
        System.out.println("Receive client : [" + msg + "]");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
