package model

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.SpringApplication
import org.springframework.context.annotation.ComponentScan
import scala.collection.JavaConversions._
import scala.beans.BeanProperty
import scala.collection.mutable.Map
import java.text.SimpleDateFormat
import java.util.Date

object Database{
  val users = Map[Int,User]()
  
// add the user object to the map
  def addUser(u: User){
    users(u.getUser_id) = u //add user

  }
  // get the a user from the map
  def getUser(user_id: Int) : User= {
    users(user_id) //return the use object
  }
  
  def updateUser(user_id: Int,u : User) : User={
  
    var oldUser:User = getUser(user_id)
    oldUser.setCreated_at(u.getCreated_at)
    oldUser.setEmail(u.getEmail)
    oldUser.setName(u.getName)
    oldUser.setPassword(u.getPassword)
    oldUser.updated_at = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
    return oldUser
  }
  //get a list of users from the map
}
