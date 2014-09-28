package model

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.SpringApplication
import org.springframework.context.annotation.ComponentScan
import scala.collection.JavaConversions._
import scala.beans.BeanProperty
import com.fasterxml.jackson.annotation.JsonProperty

class BankAccount(@JsonProperty("account_name") @BeanProperty var account_name : String,
  @JsonProperty("routing_number")@BeanProperty var routing_number : String,
  @JsonProperty("account_number")@BeanProperty var account_number : String){
  @BeanProperty var ba_id : Int = this.hashCode()
 
}