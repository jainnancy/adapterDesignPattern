object LoggerAdapter extends  LoggerHelper {
  var scrambledLogger :ScrambledLogger= _


  override def info(msg: String): Unit = {
    scrambledLogger.scrambledInfo(msg)
  }

  override def debug(msg: String): Unit = {
    scrambledLogger.scrambledDebug(msg)
  }

  override def error(msg: String): Unit = {
    scrambledLogger.scrambledError(msg)
  }


    def  getLogger(s : String): LoggerHelper ={
      scrambledLogger = new ScrambledLogger(s)
      LoggerAdapter
    }
}
