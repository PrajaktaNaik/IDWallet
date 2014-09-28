package model

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.SpringApplication
import org.springframework.context.annotation.ComponentScan
import scala.collection.JavaConversions._
import scala.beans.BeanProperty
import com.fasterxml.jackson.annotation.JsonProperty

class IdCards( @JsonProperty("card_name")@BeanProperty var card_name: String,
  @JsonProperty("card_number")@BeanProperty var card_number: String,
  @JsonProperty("expiration_date")@BeanProperty var expiration_date:String){
  @BeanProperty var card_id : Int = this.hashCode()
 
}