package kr.co.seoulit.logistics.logisticsInfo.to;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ItemGroupTO {
	 private String itemGroupCode;
	 private String description;
	 private String itemGroupName;

	 public String getItemGroupCode() { 
		 return itemGroupCode;
	 }
	 public void setItemGroupCode(String itemGroupCode) { 
		 this.itemGroupCode = itemGroupCode;
	 }
	 public String getDescription() { 
		 return description;
	 }
	 public void setDescription(String description) { 
		 this.description = description;
	 }
	 public String getItemGroupName() { 
		 return itemGroupName;
	 }
	 public void setItemGroupName(String itemGroupName) { 
		 this.itemGroupName = itemGroupName;
	 }
}