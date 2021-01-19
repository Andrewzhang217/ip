import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class Duke {

    private ArrayList<Task> list;
    private Duke(ArrayList<Task> list){

        this.list = list;

    }

    public void greeting(){
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
    }

    public void add(String input){
        Task t = new Task(input);
        this.list.add(t);
        System.out.println("added: " + input);

    }

    public void display(){
        System.out.println("Here are the tasks in your list:");
        int len = this.list.size();
                for(int i = 0; i < len; i++){
                    int index = i + 1;
                    System.out.println(index + "." + this.list.get(i).getDescription());
                }
    }

    public void markDone(int index){

        Task t = this.list.get(index);
        System.out.println("Nice! I've marked this task as done: ");
        System.out.println(t.getDescription());
        this.list.set(index, t.markAsDone());
    }
    public void bye(){
        System.out.println("Bye. Hope to see you again soon!");
    }



    public static void main(String[] args) {

        Duke duke = new Duke(new ArrayList<>());

        duke.greeting();

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.nextLine();

            if (input.equals("bye")) {
                duke.bye();
                break;
            }
            else if(input.equals("list")) {
                duke.display();

            } else if(input.startsWith("done")){
                String lastPart = input.substring(5);
                int index = Integer.parseInt(lastPart) - 1;
                duke.markDone(index);

            }
            else {
                duke.add(input);
            }
        }
    }
}
