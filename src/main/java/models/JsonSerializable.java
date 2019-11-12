package models;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.Serializable;

public class JsonSerializable<T> implements Serializable {

  private static final long serialVersionUID = 1L;

  //create ObjectMapper instance
  private static final ObjectMapper objectMapper;

  static {
    objectMapper = new ObjectMapper();
    objectMapper.setSerializationInclusion(Include.NON_NULL);
  }


  /**
   * deserializes $this to a json string ˚
   *
   * @return the json serialized string with pretty print
   * @throws JsonProcessingException thrown when there is an issue serializing the string - very
   *                                 rare
   */
  public String toJson() throws JsonProcessingException {

    //configure Object mapper for pretty print
    return objectMapper
        .writeValueAsString(this);
  }

  /**
   * to Plain Old Java Object which takes in a JSON string and converts it to the resource it was
   * originally.
   *
   * @param input JSON String of resource T
   * @return resource T from the String
   * @throws IOException thrown when there is an issue deserialize-ing the string
   */
  @SuppressWarnings("unchecked")
  public T fromJson(String input) throws IOException {
    return objectMapper.readValue(input, (Class<T>) this.getClass());
  }

  /**
   * try to call toJsonString - on failure it returns a canned response and logs the error
   *
   * @return a nonNull json string of resource T or a plain non-Json error string
   */
  @Override
  public String toString() {
    try {
      return this.toJson();
    } catch (Exception e) {
      return "Could not parse this object to String";
    }
  }
}
