package Entity;

import javax.persistence.*;

@Entity
@Table(name = "task", schema = "automator", catalog = "")
public class TaskEntity {
    private int id;
    private String type;
    private String dataTask;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "data_task")
    public String getDataTask() {
        return dataTask;
    }

    public void setDataTask(String dataTask) {
        this.dataTask = dataTask;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskEntity that = (TaskEntity) o;

        if (id != that.id) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (dataTask != null ? !dataTask.equals(that.dataTask) : that.dataTask != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (dataTask != null ? dataTask.hashCode() : 0);
        return result;
    }
}
