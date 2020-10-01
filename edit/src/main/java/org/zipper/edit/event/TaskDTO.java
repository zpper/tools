package org.zipper.edit.event;


import java.time.LocalDateTime;

/**
 * 返回的结果包含任务的id 和返回结果<br>
 * param 和data 需要实现 Serializable 接口<br>
 *
 * @author peng0806@foxmail.com <br>
 * Date: 2020/01/21.
 */
public class TaskDTO  {


    /**
     * 任务id,管理中心对每个任务生成的唯一标识
     */
    private String taskId;
    /**
     * 执行结果的提示
     */
    private String msg;

    /**
     * 执行任务的参数
     */
    private Object param;
    /**
     * 任务执行完成返回的数据
     */
    private Object data;

    /**
     * @date 2020/02/26修改为string 类型，由插件进行管理
     */
    private String path;

    /**
     * 任务是否执行成功,默认失败
     */
    private Boolean success = false;

    /**
     * 任务创建时间
     */
    private LocalDateTime createTime;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getParam() {
        return param;
    }

    public void setParam(Object param) {
        this.param = param;
    }

    public <T> T getParamValue(Class<T> cls) {

        T res = null;
        if (param != null) {
            res = (T) param;
        }
        return res;
    }


    public Object getData() {
        return data;
    }

    public <T> T getDataValue(Class<T> cls) {
        T res = null;
        if (data != null) {
            res = (T) data;
        }
        return res;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }


    @Override
    public String toString() {
        return "TaskDTO{" +
                ", taskId='" + taskId + '\'' +
                ", msg='" + msg + '\'' +
                ", param=" + param +
                ", data=" + data +
                ", path='" + path + '\'' +
                ", success=" + success +
                ", createTime=" + createTime +
                '}';
    }
}
