import org.apache.log4j.{BasicConfigurator, Logger}

class ScrambledLogger(name :String) {
  private val regex = "\\b\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\b"
  private val password = "Password: "
  private val userName = "UserName: "
  private val logger = Logger.getLogger(name)
  def scrambledInfo(message : String): Unit ={
    logger.info(scramble(message))
  }
  def scrambledDebug(message : String): Unit ={
    logger.debug(scramble(message))
  }
  def scrambledError(message : String): Unit ={
    logger.error(scramble(message))
  }

  private def scramble(message :String): String ={
    scrambleUsername(scrambleIp((scramblePassword(message))))
  }

  private def scrambleUsername(message :String): String ={
    if(message.contains(userName)){
      val index = message.indexOf(userName)+userName.length()
      val textStartedPassword = message.substring(index)
      message.substring(0,index) + "X" +textStartedPassword.substring(textStartedPassword.indexOf(" "))
    } else
      message
  }

  private def scrambleIp(message :String): String ={
    message.replaceAll(regex,"XXX.XXX.XXX.XXX")
  }
  private def scramblePassword(message :String): String ={
    if(message.contains(password)){
      val index = message.indexOf(password)+password.length()
      val textStartedPassword = message.substring(index)
      message.substring(0,index) + "X" +textStartedPassword.substring(textStartedPassword.indexOf(" "))
    } else
      message
  }
}
