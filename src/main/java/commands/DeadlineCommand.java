package commands;

import common.Message;
import data.IDuke;
import data.exception.DukeIllegalArgumentException;
import data.task.Deadline;
import data.task.ITask;

public class DeadlineCommand extends StoreCommand{

    private final String description;
    private final String time;

    private DeadlineCommand(String description, String time, IDuke duke) {
        super(-1, duke);
        this.description = description;
        this.time = time;
    }

    public static DeadlineCommand getDeadlineCommand(String description, String time) {
        return new DeadlineCommand(description, time, null);
    }

    private String handleDeadline(String description, String time)
            throws DukeIllegalArgumentException {
        if (description.matches("\\s*")) {
            throw new DukeIllegalArgumentException(
                    "The description of deadline cannot be empty!");
        }
        if (time.matches("\\s*")) {
            throw new DukeIllegalArgumentException(
                    "The time of deadline cannot be empty!");
        }

        ITask task = Deadline.getDeadline(description, time);
        storeTask(task);
        String output = "Got it. I've added this task:\n\t" + task.toString()
                + "\nNow you have " + duke.numOfTasks() + " task(s) in the list.";
        System.out.print(output);
        return output;
    }

    @Override
    public String execute() {
        if (duke == null) {
            throw new RuntimeException(Message.ERR_DUKE_NOT_INIT.toString());
        }
        return handleDeadline(description, time);
    }




}
