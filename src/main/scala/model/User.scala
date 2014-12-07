package model

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import scala.util
import org.springframework.boot.SpringApplication
import org.springframework.context.annotation.ComponentScan
import scala.collection.JavaConversions._
import scala.beans.BeanProperty
import java.text.SimpleDateFormat
import java.util.Date
import scala.collection.mutable.Map
import com.fasterxml.jackson.annotation.JsonProperty
import org.apache.log4j.Logger
import scala.annotation.meta.beanGetter
import javax.validation.constraints.{Min, NotNull}
import org.hibernate.validator.constraints.NotEmpty

class User(@JsonProperty("email")@BeanProperty @(NotNull @beanGetter)@(NotEmpty @beanGetter) var email: String, @JsonProperty("name")@BeanProperty @(NotNull @beanGetter)@(NotEmpty @beanGetter) var name: String,
  @JsonProperty("password")@BeanProperty  @(NotNull@beanGetter) @(NotEmpty @beanGetter)  var password: String) {
  @BeanProperty val user_id: Int = this.hashCode();
  @BeanProperty var created_at: String = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
  @BeanProperty var updated_at: String = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
  var idCards = Map[Int, IdCards]()
  var webLogin = Map[Int, WebLogin]()
  var bankAccount = Map[Int, BankAccount]()
  val logger = Logger.getLogger(getClass().getName());
  
  //add one id card
  def addIdCard(idcard: IdCards) {
    idCards(idcard.getCard_id) = idcard
  }

  //view one id card
  def getIdCard(card_id: Int): IdCards = {
    idCards(card_id)
  }

  //view all idcard
  def viewallIdCard(): List[IdCards] = {
    idCards.keys.foreach { i =>
      logger.info("key:" + i)
      logger.info(" Value = " + idCards(i))
    }

    idCards.values.toList //pass the map object
  }

  //delete one id card
  def deleteIdCard(card_id: Int) {
    if (idCards.contains(card_id)) {
      idCards.remove(card_id)
    }

  }

  //add one weblogin
  def addWebLogin(wlogin: WebLogin) {
    webLogin(wlogin.getLogin_id) = wlogin //add user
  }

  //get one weblogin
  def getWebLogin(login_id: Int): WebLogin = {
    webLogin(login_id)
  }

  //view all weblogin
  def viewallWebLogin(): Map[Int, WebLogin] = {
    webLogin
  }

  //delete one web login
  def deleteWebLogin(login_id: Int) {
    if (webLogin.contains(login_id)) {
      webLogin.remove(login_id)
    }
  }

  //add one bank account
  def addBankAcc(bankAcc: BankAccount) {
    bankAccount(bankAcc.getBa_id) = bankAcc
  }

  //get one bank account
  def getBankAcc(ba_id: Int): BankAccount = {
    bankAccount(ba_id)
  }

  //get list of bank account
  def viewallBankAcc(): Map[Int, BankAccount] = {
    bankAccount
  }

  //delete one bank account
  def deleteBankAccount(ba_id: Int) {
    if (bankAccount.contains(ba_id)) {
      bankAccount.remove(ba_id)
    }
  }
}
