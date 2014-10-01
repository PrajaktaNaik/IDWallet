package controller

import java.util.concurrent.atomic.AtomicLong
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import scala.collection.JavaConversions._
import org.springframework.web.bind.annotation.RequestBody
import model.User
import model.Database
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMethod
import model.IdCards
import scala.collection.mutable.Map
import model.WebLogin
import model.BankAccount
import collection.JavaConverters._
import org.apache.log4j.Logger
import javax.validation.Valid

@RestController
class ApplicationController {

  val logger = Logger.getLogger(getClass().getName());
  //create user
  @RequestMapping(method = Array(RequestMethod.POST), value = Array("/users"))
  def createUser(@Valid @RequestBody user: User): User = {

    Database.addUser(user) // add the object user in the map
    Database.getUser(user.getUser_id) // return the user response converted to json
  }

  //view user
  @RequestMapping(Array("/users/{user_id}"))
  def viewUser(@PathVariable user_id: Int): User = {
    Database.getUser(user_id) //get the user from map 
  }

  //update user
  @RequestMapping(method = Array(RequestMethod.PUT), value = Array("/users/{user_id}"))
  def updateUser(@PathVariable user_id: Int, @Valid @RequestBody user: User): User = {
    Database.updateUser(user_id, user)
  }

  //create the IDcard
  @RequestMapping(method = Array(RequestMethod.POST), value = Array("/users/{user_id}/idcards"))
  def createIdCard(@PathVariable user_id: Int, @Valid @RequestBody id_card: IdCards): IdCards = {
    // first get the user of this particular user_id
    val u: User = Database.getUser(user_id)
    // add the idcard information to this user.
    u.addIdCard(id_card)
    logger.info("Size1:" + u.idCards.size)
    u.getIdCard(id_card.getCard_id)
  }

  //List all ID cards
  //Resource: /users/{user_id}/idcards.  List zero or more ID cards from the wallet.
  @RequestMapping(Array("users/{user_id}/idcards"))
  def viewIdCards(@PathVariable user_id: Int): java.util.List[IdCards] = {
    val u: User = Database.getUser(user_id)
    logger.info("Size2:" + u.idCards.size)
    u.viewallIdCard().asJava
  }

  //delete  one idcard of a particular user
  @RequestMapping(Array("users/{user_id}/idcards/{card_id}"))
  def deleteIdCard(@PathVariable user_id: Int, @PathVariable card_id: Int) {
    val u: User = Database.getUser(user_id)
    u.deleteIdCard(card_id)
  }

  //create a web login
  @RequestMapping(method = Array(RequestMethod.POST), value = Array("/users/{user_id}/weblogins"))
  def createWebLogin(@PathVariable user_id: Int, @Valid @RequestBody weblogin: WebLogin): WebLogin = {
    // first get the user of this particular user_id
    val u: User = Database.getUser(user_id)
    // add the web login information to this user.
    u.addWebLogin(weblogin)
    u.getWebLogin(weblogin.getLogin_id)

  }

  //list all web login
  @RequestMapping(Array("users/{user_id}/weblogins"))
  def viewWebLogins(@PathVariable user_id: Int): java.util.Map[Int, WebLogin] = {
    val u: User = Database.getUser(user_id)
    u.viewallWebLogin().asJava
  }

  //delete a web login
  @RequestMapping(Array("users/{user_id}/weblogins/{login_id}"))
  def deleteWebLogin(@PathVariable user_id: Int, @PathVariable login_id: Int) {
    val u: User = Database.getUser(user_id)
    u.deleteWebLogin(login_id)
  }
  //create a bank account
  @RequestMapping(method = Array(RequestMethod.POST), value = Array("/users/{user_id}/bankaccounts"))
  def createBankAccount(@PathVariable user_id: Int, @Valid @RequestBody bankAccount: BankAccount): BankAccount = {
    // first get the user of this particular user_id
    val u: User = Database.getUser(user_id)
    // add the bank acc information to this user.
    u.addBankAcc(bankAccount)
    u.getBankAcc(bankAccount.getBa_id)
  }
  //list all bank account
  @RequestMapping(Array("users/{user_id}/bankaccounts"))
  def viewBankAccounts(@PathVariable user_id: Int): java.util.Map[Int, BankAccount] = {
    val u: User = Database.getUser(user_id)
    u.viewallBankAcc().asJava
  }

  //delete a bank account
  @RequestMapping(Array("users/{user_id}/bankaccounts/{ba_id}"))
  def deleteBankAccount(@PathVariable user_id: Int, @PathVariable ba_id: Int) {
    val u: User = Database.getUser(user_id)
    u.deleteBankAccount(ba_id)
  }
}
