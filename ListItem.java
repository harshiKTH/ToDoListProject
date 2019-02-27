import java.io.Serializable;
import java.util.Date;

public  class ListItem implements Serializable{

    private Date dueDate = null;
    private String task = null;

    private static String status = Constants.STATUS_PENDING;

    public  String getStatus() {
        return status;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
