package compile;

public class Answer {
    /*
        运行结果是否正确
        0表示编译运行都成功
        1表示编译出错
        2表示编译通过，运行出错
    */
    private int errNo;
    /*
        errNo 1, reason包含了编译错误的信息
        errNo 2, reason包含了异常的调用栈信息
     */
    private String reason;

    private String stdOut;

    private String stdErr;

    public int getErrNo() {
        return errNo;
    }

    public void setErrNo(int errNo) {
        this.errNo = errNo;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStdOut() {
        return stdOut;
    }

    public void setStdOut(String stdOut) {
        this.stdOut = stdOut;
    }

    public String getStdErr() {
        return stdErr;
    }

    public void setStdErr(String stdErr) {
        this.stdErr = stdErr;
    }
}
