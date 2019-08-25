package io.netty_definitive_guide.chapter8;

import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.InvalidProtocolBufferException;

import io.netty_definitive_guide.chapter8.protobuf.SubscribeReqProto;

public class SubscribeReqProtoDemo {
    private static byte[] encode(SubscribeReqProto.SubscribeReq req) {
        return req.toByteArray();
    }

    private static SubscribeReqProto.SubscribeReq decode(byte[] body) throws InvalidProtocolBufferException {
        return SubscribeReqProto.SubscribeReq.parseFrom(body);
    }

    private static SubscribeReqProto.SubscribeReq createSubscribeReq() {
        SubscribeReqProto.SubscribeReq.Builder builder = SubscribeReqProto.SubscribeReq.newBuilder();
        builder.setSubReqId(1);
        builder.setUserName("abc");
        builder.setProductName("netty book");
        List<String> address = new ArrayList<>();
        address.add("Nanjing");
        address.add("Beijing");
        address.add("Shanghai");
        builder.addAllAddress(address);
        return builder.build();
    }

    public static void main(String[] args) throws InvalidProtocolBufferException {
        SubscribeReqProto.SubscribeReq req = createSubscribeReq();
        System.out.println("Before encode: " + req.toString());
        SubscribeReqProto.SubscribeReq req2 = decode(encode(req));
        System.out.println("After decode: " + req2.toString());
        System.out.println("Assert equal: -->" + req2.equals(req));
    }
}
