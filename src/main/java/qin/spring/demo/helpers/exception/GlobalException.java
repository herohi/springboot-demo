package qin.spring.demo.helpers.exception;

import qin.spring.demo.helpers.response.CodeMsg;

/**
 * 自定义全局异常类，在 Controller 中使用
 */
public class GlobalException extends RuntimeException {
    private final CodeMsg codeMsg;

    public GlobalException(CodeMsg codeMsg) {
        super(codeMsg.toString());
        this.codeMsg = codeMsg;
    }

    public CodeMsg getCodeMsg() {
        return codeMsg;
    }
}
