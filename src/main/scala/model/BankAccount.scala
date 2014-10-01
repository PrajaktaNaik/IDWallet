package model

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import scala.annotation.meta.beanGetter
import javax.validation.constraints.{ Min, NotNull }
import org.hibernate.validator.constraints.NotEmpty
import org.springframework.boot.SpringApplication
import org.springframework.context.annotation.ComponentScan
import scala.collection.JavaConversions._
import scala.beans.BeanProperty
import com.fasterxml.jackson.annotation.JsonProperty

class BankAccount(@JsonProperty("account_name")@BeanProperty @(NotNull @beanGetter)@(NotEmpty @beanGetter) var account_name: String,
  @JsonProperty("routing_number")@BeanProperty @(NotNull @beanGetter)@(NotEmpty @beanGetter) var routing_number: String,
  @JsonProperty("account_number")@BeanProperty @(NotNull @beanGetter)@(NotEmpty @beanGetter) var account_number: String) {
  @BeanProperty var ba_id: Int = this.hashCode()

}