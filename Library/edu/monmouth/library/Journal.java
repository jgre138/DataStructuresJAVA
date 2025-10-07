package edu.monmouth.library;

public class Journal implements LibraryItem{

	private String title, editor;
	private int volume;
	private StatusType status;
	
	
	public Journal(String title, String editor, int volume, StatusType status) throws JournalException{
		super();
		setTitle(title);
		setEditor(editor);
		setVolume(volume);
		setStatus(status);
	}
	

	public String getEditor() {
		return editor;
	}


	public void setEditor(String editor) throws JournalException{
		if (editor == null || editor.length() == JournalConstants.MINLENGTH) {
			throw new JournalException("The editor field cannot be empty");
		}	
		else {
			this.editor = editor;
		}	
	}


	public int getVolume() {
		return volume;
	}


	public void setVolume(int volume) throws JournalException{
		if (volume >= JournalConstants.MINVOLUMES) {
			this.volume = volume;
		}
		else {
			throw new JournalException("The volume must be greater-than or equal to 1");
		}
	}


	public StatusType getStatus() {
		return status;
	}


	public void setStatus(StatusType status){ 
		this.status = status;
	}


	public void setTitle(String title) throws JournalException{
		if (title == null || title.length() == JournalConstants.MINLENGTH) {
			throw new JournalException("The title field cannot be empty");
		}	
		else {
			this.title = title;
		}
	}


	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public boolean isAvailible() {
		if (status == StatusType.ONSHELF) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void borrowItem() {
		setStatus(StatusType.BORROWED);
		
	}

	@Override
	public void returnItem() {
		setStatus(StatusType.ONSHELF);
	}


	@Override
	public String toString() {
		return "Journal [title=" + title + ", editor=" + editor + ", volume=" + volume + ", status=" + status + "]";
	}
	
	

}
