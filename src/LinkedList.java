import java.io.*;

public class LinkedList {

    private Node root;
    private int size;

    private Student tempUpdateRecord;


    public LinkedList()
    {
        root = null;
        size = 0;
    }

    public boolean isEmpty()
    {
        if (root == null)
        {
            return true;
        }

        else
        {
            return false;
        }

    }

    public int getSize()
    {
        return size;
    }

    public void loadDataFromFile(LinkedList linkedList){

         String fileName = "C:\\Users\\HP\\Desktop\\DSAProject\\src\\studentRecord.txt";
         String line = null;
        String fName ="";
        String lName = "";
        String id = "";

        int counter = 1;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                if(counter == 1){
                    fName = line;
                    counter++;
                }else if(counter == 2){
                    lName = line;
                    counter++;
                }else if(counter == 3){
                    id = line;
                    counter = 4;
                }else{
                    linkedList.insertNewRecord(new Student(fName,lName,id));
                    counter = 1;
                }

               // System.out.println(line);
                //System.out.println(fName);

            }

            bufferedReader.close();
            fileReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");

        }

    }

    public void savaRecordInFile(){
        FileWriter fw= null;
        BufferedWriter bfr=null;

        try {
            fw= new FileWriter("C:\\Users\\HP\\Desktop\\DSAProject\\src\\studentRecord.txt",false);

            bfr= new BufferedWriter(fw);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Node temp = root;
            while (temp.nextNode !=null){
                bfr.write(temp.student.getfNmae());
                bfr.newLine();
                bfr.write(temp.student.getlName());
                bfr.newLine();
                bfr.write(temp.student.getId());
                bfr.newLine();
                bfr.newLine();
                temp = temp.nextNode;
            }

            bfr.write(temp.student.getfNmae());
            bfr.newLine();
            bfr.write(temp.student.getlName());
            bfr.newLine();
            bfr.write(temp.student.getId());
            bfr.newLine();
            bfr.newLine();

            bfr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void insertNewRecord(Student newStudent)
    {
        Node newRecord,temp;
        newRecord = new Node(newStudent);
        temp = root;
        if (isEmpty())
        {
            newRecord = new Node(newStudent);
            root = newRecord;
            root.nextNode = null;
            size++;
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("New record has been added into the system " );
            System.out.println("First Name \tLast Name \tId ");
            System.out.println(newStudent.getfNmae() + "\t\t"+newStudent.getlName()+"\t\t"+newStudent.getId());
            System.out.println("-----------------------------------------------------------------------\n");
        }else{

            if(search(newStudent.getId())){
                System.out.println("SORRY CANT SAVE THIS RECORD THIS ID ALREADY EXIST");

            }
            else {
                for (int i = 1; i < size; i++)
                {
                    temp = temp.nextNode;
                }
                newRecord.nextNode = temp.nextNode;
                temp.nextNode = newRecord;
                size++;
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("New record has been added into the system " );
                System.out.println("First Name \tLast Name \tId ");
                System.out.println(newStudent.getfNmae() + "\t\t"+newStudent.getlName()+"\t\t"+newStudent.getId());
                System.out.println("-----------------------------------------------------------------------\n");
            }

        }




    }

    public void deleteRecord(String studentId)
    {
        if(search(studentId))
        {
           int indexOfRecord =  getIndex(studentId);
            if (indexOfRecord == 1)
            {
                deleteStart();
            }
            else if(indexOfRecord == size)
            {
                deleteLast();

            }
            else if (indexOfRecord > 1 && indexOfRecord <=size)
            {
                Node t = root , n;
                for (int i = 1; i < indexOfRecord - 1 ; i++)
                {
                    t = t.nextNode;
                }

                n = t.nextNode;
                t.nextNode = n.nextNode;
                n = null;
                size--;
                //System.out.println("Value at position " + pos+ " deleted from list");

            }

        }else{
            System.out.println("You have enter wrong ID");
        }



    }




    public void update(String studentId,Student newRecord){

        if(search(studentId))
        {
            tempUpdateRecord.setfNmae(newRecord.getfNmae());
            tempUpdateRecord.setlName(newRecord.getlName());
            tempUpdateRecord.setId(newRecord.getId());
            System.out.println(studentId + " this record has been updated");

        }else{
            System.out.println("You have enter wrong ID");
        }
    }

    public boolean search(String studentId)
    {
        Node temp = root;

        for (int i = 1; i <=size; i++)
        {
            if (temp.student.getId().equals(studentId) )
            {
                tempUpdateRecord = temp.student;
                return true;
            }
            temp = temp.nextNode;
        }

        return false;

    }


    public void displayAllRecord(){
        Node temp = root;

        if(isEmpty()){
            System.out.println("No data has been save yet");
        }else{
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("\t\t\t ALL RECORDS");
            System.out.println("First Name \tLast Name \tId ");
            while (temp.nextNode != null){
                System.out.println(temp.student.getfNmae() + "\t\t"+temp.student.getlName()+"\t\t"+temp.student.getId());
               temp = temp.nextNode;
            }
            System.out.println(temp.student.getfNmae() + "\t\t"+temp.student.getlName()+"\t\t"+temp.student.getId());
            System.out.println("-----------------------------------------------------------------------\n");
        }

    }

    /////////////////////////////////////////////////////// utility function

    private int getIndex(String studentId){
        int index = 1;
        Node temp = root;

        for (int i = 1; i <=size; i++)
        {
            if (temp.student.getId().equals(studentId) )
            {
                tempUpdateRecord = temp.student;
                return index;
            }
            temp = temp.nextNode;
            index++;
        }

        return index;
    }

    private void deleteStart()
    {
        if (isEmpty())
        {
            System.out.println("Empty Linked List..");
        }
        else
        {
            Node n;
            n = root.nextNode;
            root = null;
            root = n;
            size--;
            System.out.println("First node deleted from list");

        }

    }

    private void deleteLast()
    {
        Node t = root;
        if (isEmpty())
        {
            System.out.println("Empty Linked List..");
        }
        else
        {
            for (int i = 1; i <size-1; i++)
            {
                t = t.nextNode;
            }
            t.nextNode = null;
            size--;
            System.out.println("Last node deleted from list");
        }

    }

}
