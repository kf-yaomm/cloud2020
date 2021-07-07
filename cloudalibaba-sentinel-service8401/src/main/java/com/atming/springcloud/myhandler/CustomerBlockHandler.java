package com.atming.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atming.springcloud.entities.CommonResult;

/**
 *全局异常处理
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(4444, "按客户自定义,global handlerException----------1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(4444, "按客户自定义2,global handlerException----------2");
    }
}
