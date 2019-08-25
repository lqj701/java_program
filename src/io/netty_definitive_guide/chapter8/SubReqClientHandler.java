package io.netty_definitive_guide.chapter8;

import java.util.ArrayList;
import java.util.List;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty_definitive_guide.chapter8.protobuf.SubscribeReqProto;

public class SubReqClientHandler extends ChannelHandlerAdapter {
    public SubReqClientHandler() {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        for (int i = 0; i < 10; i++) {
            ctx.write(subReq(i));
        }
        ctx.flush();
    }

    private SubscribeReqProto.SubscribeReq subReq(int i) {
        SubscribeReqProto.SubscribeReq.Builder builder = SubscribeReqProto.SubscribeReq.newBuilder();

        builder.setSubReqId(i);
        builder.setUserName("abc");
        builder.setProductName("netty book");
        List<String> address = new ArrayList<>();
        address.add("Nanjing");
        address.add("Beijing");
        address.add("Shanghai");
        builder.addAllAddress(address);
        return builder.build();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("receive server response : [" + msg + "]");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
