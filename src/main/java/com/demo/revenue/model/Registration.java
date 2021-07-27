package com.demo.revenue.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Registration
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-25T02:12:24.601+10:00[Australia/Sydney]")

public class Registration {
	@JsonProperty("id")
	private Long id;

	@JsonProperty("person_id")
	private Long personId;

	@NotNull
	@JsonProperty("vehicle_id")
	private Long vehicleId;

	public Registration id(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 */
	@ApiModelProperty(value = "")

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Registration personId(Long personId) {
		this.personId = personId;
		return this;
	}

	/**
	 * Get personId
	 * 
	 * @return personId
	 */
	@ApiModelProperty(value = "")

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public Registration vehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
		return this;
	}

	/**
	 * Get vehicleId
	 * 
	 * @return vehicleId
	 */
	@ApiModelProperty(value = "")

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Registration registration = (Registration) o;
		return Objects.equals(this.id, registration.id)
				&& Objects.equals(this.personId, registration.personId)
				&& Objects.equals(this.vehicleId, registration.vehicleId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, personId, vehicleId);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Registration {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    personId: ").append(toIndentedString(personId)).append("\n");
		sb.append("    vehicleId: ").append(toIndentedString(vehicleId)).append("\n");
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
