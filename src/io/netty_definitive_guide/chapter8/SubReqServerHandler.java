package io.netty_definitive_guide.chapter8;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty_definitive_guide.chapter8.protobuf.SubscribeReqProto;
import io.netty_definitive_guide.chapter8.protobuf.SubscribeRespProto;

public class SubReqServerHandler extends ChannelHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        SubscribeReqProto.SubscribeReq req = (SubscribeReqProto.SubscribeReq) msg;
        if ("abc".equalsIgnoreCase(req.getUserName())) {
            System.out.println("service accept client subscribe req : [" + req.toString() + "]");
            ctx.writeAndFlush(resp(req.getSubReqId()));
        }
    }

    private SubscribeRespProto.SubscribeResp resp(int subReqId) {
        SubscribeRespProto.SubscribeResp.Builder builder = SubscribeRespProto.SubscribeResp.newBuilder();
        builder.setSubReqId(0);
        builder.setRespCode(0);
        builder.setDesc("netty book order succeed,3 days later,sent to the designed address");
        return builder.build();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
