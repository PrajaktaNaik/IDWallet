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

class WebLogin(@JsonProperty("url")@BeanProperty @(NotNull @beanGetter)@(NotEmpty @beanGetter) var url: String,
  @JsonProperty("login")@BeanProperty @(NotNull @beanGetter)@(NotEmpty @beanGetter) var login: String,
  @JsonProperty("password")@BeanProperty @(NotNull @beanGetter)@(NotEmpty @beanGetter) var password: String) {
  @BeanProperty var login_id: Int = this.hashCode()

}

