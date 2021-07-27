package com.demo.revenue.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Vehicle
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-25T02:12:24.601+10:00[Australia/Sydney]")

public class Vehicle {
	@JsonProperty("model")
	private String model;

	@JsonProperty("color")
	private String color;

	@JsonProperty("plateNo")
	private String plateNo;

	public Vehicle(String model, String color, String plateNo) {
		this.model = model;
		this.color = color;
		this.plateNo = plateNo;
	}

	public Vehicle model(String model) {
		this.model = model;
		return this;
	}

	/**
	 * Get model
	 * 
	 * @return model
	 */
	@ApiModelProperty(value = "")

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Vehicle color(String color) {
		this.color = color;
		return this;
	}

	/**
	 * Get color
	 * 
	 * @return color
	 */
	@ApiModelProperty(value = "")

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Vehicle plateNo(String plateNo) {
		this.plateNo = plateNo;
		return this;
	}

	/**
	 * Get plateNo
	 * 
	 * @return plateNo
	 */
	@ApiModelProperty(value = "")

	public String getPlateNo() {
		return plateNo;
	}

	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Vehicle vehicle = (Vehicle) o;
		return Objects.equals(this.model, vehicle.model)
				&& Objects.equals(this.color, vehicle.color)
				&& Objects.equals(this.plateNo, vehicle.plateNo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(model, color, plateNo);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Vehicle {\n");

		sb.append("    model: ").append(toIndentedString(model)).append("\n");
		sb.append("    color: ").append(toIndentedString(color)).append("\n");
		sb.append("    plateNo: ").append(toIndentedString(plateNo)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
