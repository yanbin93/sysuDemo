package model;
import java.util.Date;
public class Product {
	private Integer id;
	private Integer productId;
	private String productName;
	private String productCode;
	private String productNo;
	private String productBatch;
	private Date productStart;
	private Date productEnd;
	private String description;
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCode() {
		return this.productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductNo() {
		return this.productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getProductBatch() {
		return this.productBatch;
	}

	public void setProductBatch(String productBatch) {
		this.productBatch = productBatch;
	}

	public Date getProductStart() {
		return this.productStart;
	}

	public void setProductStart(Date productStart) {
		this.productStart = productStart;
	}

	public Date getProductEnd() {
		return this.productEnd;
	}

	public void setProductEnd(Date productEnd) {
		this.productEnd = productEnd;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}