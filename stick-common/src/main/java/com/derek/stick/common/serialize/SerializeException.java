package com.derek.stick.common.serialize;

/**
 * @author derek.wu
 * @date 2017-12-09
 * @since v1.0.0
 */
public class SerializeException extends RuntimeException {

    public SerializeException() {
        super();
    }

    public SerializeException(String errMsg) {
        super(errMsg);
    }

    public SerializeException(Throwable cause) {
        super(cause);
    }

    public SerializeException(String errMsg, Throwable cause) {
        super(errMsg, cause);
    }
}
