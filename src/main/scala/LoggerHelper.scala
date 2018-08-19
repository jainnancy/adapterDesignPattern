import org.apache.log4j.Logger

trait LoggerHelper {
//  val logger = Logger.getLogger(this.getClass.getName)
  def info(msg : String)
  def debug(msg : String)
  def error(msg : String)
}
