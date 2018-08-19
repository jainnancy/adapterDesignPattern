import org.apache.log4j.BasicConfigurator

object Client extends App  {
  BasicConfigurator.configure()
  val logger: LoggerHelper = LoggerAdapter.getLogger(this.getClass.getName)
  logger.info("Log Contains IP address: 127.0.0.1")
  logger.debug("UserName: jainnancy trying to sign in")
  logger.error("Password: abxyz is wrong ")
}