package tester;
import java.io.IOException;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import control.Manager;
import model.Breakdown;
import model.Group;
import model.Machine;
import model.Message;
import model.Repair;
import model.Section;
import model.User;
import model.WorkOrder;

public class MainClient implements MessageListener {

    private final int PORT = 8008;
    private final String IP = "localhost";
    private Socket cs;

    Manager manager;

    public static void main(String[] args){
        try {
            MainClient mc = new MainClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MainClient() throws IOException {
        cs = new Socket(IP,PORT);
        int opc = 0;
        while(opc != -1){
            System.out.println("elige");
            opc = Utilidades.leerInt();
            doThings(opc);
            System.out.println(opc);
        }
    }

    private void doThings(int opc) {
        try {
            switch (opc) {
                case 1:
                    login();
                    break;
                case 2:
                    addBreakDown();
                    break;
                case 3:
                    addRepair();
                    break;
                case 4:
                    getBreakdown();
                    break;
                case 5:
                    getGroup();
                    break;
                case 6:
                    getLocalization();
                    break;
                case 7:
                    getMachine();
                    break;
                case 8:
                    getRepair();
                    break;
                case 9:
                    getUser();
                    break;
                case 10:
                    getWorkOrder();
                    break;
                case 11:
                	getMachine();
                	break;
                default:
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //System.exit(0);
        }
    }

    private void getWorkOrder() {
        WorkOrder wo = new WorkOrder();
        Repair rep = new Repair();
        Group gr=new Group(8);
        rep.setGroup(gr);
        wo.setRepairs(rep);
        
        
        Breakdown br = new Breakdown(1);
        wo.setBreakdown(br);
        Message msg = new Message(Message.GET,Message.WORK_ORDER,wo);
        ThreadSender ts = new ThreadSender(this,cs,msg);
        ts.start();

    }

    private void getUser() {
    	User user = new User("unaisainz");
        Message msg = new Message(Message.GET,Message.USER,user);
        ThreadSender ts = new ThreadSender(this,cs,msg);
        ts.start();

    }

    private void getRepair() {
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	WorkOrder wo = new WorkOrder();
   		wo.setBreakdown(new Breakdown(1));
   		Repair rep = null;
		try {
			rep = new Repair(format.parse("1990-01-01 00:00:00"), 1, 4f, "2", "xDDDD", true, "eee");
			rep.setGroup(new Group(8));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   		wo.setRepairs(rep);
        Message msg = new Message(Message.GET, Message.REPAIR, wo);
       
        ThreadSender ts = new ThreadSender(this, cs, msg);
        ts.start();
    }

    private void getMachine() {
    	Machine m = new Machine("CF 1");
        Message msg = new Message(Message.GET, Message.MACHINE, m);
       
        ThreadSender ts = new ThreadSender(this, cs, msg);
        ts.start();
    }

    private void getLocalization() {
        Section s = new Section();
        s.setId("1");
        Message msg = new Message(Message.GET, Message.WORK_ZONE, s);
        
        ThreadSender ts = new ThreadSender(this, cs, msg);
        ts.start();

    }

    private void getGroup() {
        Group gr = new Group(8);
        Message msg = new Message(Message.GET, Message.GROUP, gr);
        ThreadSender ts = new ThreadSender(this, cs, msg);
        ts.start();

    }

    private void getBreakdown() {
    	Breakdown br = new Breakdown(1);
        Message msg = new Message(Message.GET, Message.BREAKDOWN, br);
        ThreadSender ts = new ThreadSender(this, cs, msg);
        ts.start();
    }

    private void addRepair() {
    	WorkOrder wo = new WorkOrder();
    	wo.setBreakdown(new Breakdown(1));
    	wo.setCreationDate(new Date());
    	wo.setOthers("MongoLite");
    	wo.setSeverity(2);
    	wo.setTypeOfMaintenance("e");
    	Repair rep = new Repair(new Date(), 1, 4f, "2", "xDDDD", true, "eee");
    	rep.setGroup(new Group(8));
        wo.setRepairs(rep);
    	Message msg = new Message(Message.ADD, Message.REPAIR, wo);
        ThreadSender ts = new ThreadSender(this, cs, msg);
        ts.start();
    }

    private void addBreakDown() {
        User user = new User("1dfm");
        Breakdown br = new Breakdown(
        		0, 
        		new Date(),
        		user, 
        		"Mechanical" , 
        		"Broken screw", 
        		"The main screw is broken", 
        		new Machine("CF 1"), 
        		"R");
        Message msg = new Message(Message.ADD, Message.BREAKDOWN, br);
        ThreadSender ts = new ThreadSender(this, cs, msg);
        ts.start();

    }

    private void login() throws Exception {
    	//General
    	/*
        User user = new User("1dfm", "1dfm");
        Message msg = new Message(Message.LOGIN,null,user);
        ThreadSender ts = new ThreadSender(this,cs,msg);
        ts.start();*/
        //Admin
    	/*
        User user = new User("admin", "admin");
        Message msg = new Message(Message.LOGIN,null,user);
        ThreadSender ts = new ThreadSender(this,cs,msg);
        ts.start();
        */
        //Maintenance con grupo
    	
        User user = new User("unaisainz", "unaisainz");
        Message msg = new Message(Message.LOGIN,null,user);
        ThreadSender ts = new ThreadSender(this,cs,msg);
        ts.start();
        
        //Maintenance sin grupo
    	/*
        User user = new User("tek1", "tek1");
        Message msg = new Message(Message.LOGIN,null,user);
        ThreadSender ts = new ThreadSender(this,cs,msg);
        ts.start();
        */
    }


    @Override
    public void messageReceived(Object obj) {
        System.out.println(obj);
    }
}