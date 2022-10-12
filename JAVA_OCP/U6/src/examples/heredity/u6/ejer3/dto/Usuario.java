package examples.heredity.u6.ejer3.dto;

import java.util.Arrays;

public class Usuario extends Person {
	public static enum TYPE{ADMIN,USER,EXT;};
	
	private String addres;
	private TYPE type;
	
	private Tarea[] taks;
	private Evento[] event;
	private int nTaks, nEvent;
	public Usuario() {
		super();
		this.nTaks = 0;
		this.nEvent = 0;
	}
	public Usuario(String name, String pwd, String email, String addres, String phone1, TYPE type) {
		super(name, pwd, email, phone1);
		this.addres = addres;
		this.type = type;
		this.nTaks = 0;
		this.nEvent = 0;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public TYPE getType() {
		return type;
	}

	public void setType(TYPE type) {
		this.type = type;
	}
	
	public void setTaks(Tarea taks) {
		if(!taksEmpaty()) {
			this.nTaks++;
			this.taks= new Tarea[this.nTaks];
		}else {
			this.nTaks++;
		}
		
		this.taks = Arrays.copyOf(this.taks, this.nTaks);
		this.taks[this.nTaks] = new Tarea(taks);
	}
	
	public Tarea[] getTask() {
		if(taksEmpaty())
			return null;
		return this.taks;
	}
	
	public void setEvent(Evento event) {
		if(!eventEmpaty()) {
			this.nEvent++;
			this.event = new Evento[this.nEvent];
		}else {
			this.nEvent++;
			Arrays.copyOf(this.event, this.nEvent);
		}
		this.event[this.nEvent] = event;
	}
	
	public Evento[] getEvent() {
		if(eventEmpaty())
			return null;
		return this.event;
	}
	
	private boolean taksEmpaty(){
		return this.nTaks==0?true:false;
	}
	
	private boolean eventEmpaty(){
		return this.nEvent==0?true:false;
	}
	
	
	@Override
	public String toString() {
		return super.toString()+" \n Usuario [addres=" + addres + ", type=" + type + "]";
	}
}
