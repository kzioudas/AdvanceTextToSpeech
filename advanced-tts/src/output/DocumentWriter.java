package output;

import java.util.List;

public interface DocumentWriter {

	List<String> write();

	List<String> getContents();
	

	void setContents(List<String> con);
}
