import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class SmartDevices constructor(val name: String, val status: String){
    constructor(name: String): this(name = name, status = "Online"){
        println("The device is connected to Internet")
    }
    open var deviceType = "unknown"
    var deviceStatus = "Offline"
        protected set

    constructor(name: String, code: Int): this(name = name, status = when(code){
        0 -> "Offline"
        1 -> "Online"
        else -> "Invalid"
    })
    internal fun printInfo(){
        println("Device name: $name, Device status: $status, Device Type: $deviceType")
    }
    open fun turnOn() {
        deviceStatus = "Online"
        println("Smart device is turned on.")
    }
    open fun turnOff() {
        deviceStatus = "Offline"
        println("Smart device is turned off.")
    }
}

class SmartTV(deviceName: String, deviceStatus: String) :
SmartDevices(name = deviceName, status = deviceStatus) {
    private var volume by RangeRegulator(5, 0, 100)
        // Now, used by delegate
        // set(value){
        //     if (value in 1..100){
        //         field = value
        //     }
        // }
    private var channel by RangeRegulator(3, 1, 200)
        // set(value){
        //     if(value in 1..200){
        //         field = value
        //     }
        // }
    
    override var deviceType = "Screen"

    override fun turnOn() {
        super.turnOn()
        println("Tv turned on, Channel set to $channel and volume is $volume")
    }

    override fun turnOff() {
        println("Tv has been turned off")
    }

    fun increaseVolume(){
        volume++
        println("Volume incresed to ${volume}")
    }

    fun decreaseVolume() {
        volume--
    }

    fun nextChannel(){
        channel++
        println("Channel set to ${channel}")
    }

    fun previousChannel() {
        channel--
    }
}

class SmartLight(deviceName: String, deviceStatus: String) :
SmartDevices(name = deviceName, status = deviceStatus){
    constructor(Dname: String): this(deviceName = Dname, deviceStatus = "Online")
    private var brightness by RangeRegulator(4, 1, 100)
        // set(value) {
        //     if(value in 1..80){
        //         field = value
        //     }
        // }

    override var deviceType = "Light"
    override fun turnOn() {
        println("Light has been turned on, brightness level $brightness")
    }

    override fun turnOff() {
        println("Light has been turned off")
    }

    fun increaseBrightness() {
        brightness++
    }

}

// SmartHome HAS-A SmartTv, SmartLight
class SmartHome(
    var smartTv: SmartTV,
    val smartLight: SmartLight
) {

    var deviceTurnOnCount = 0
    fun turnOnTv() {
        deviceTurnOnCount++
        smartTv.turnOn()
    }
    
    fun turnOffTv() {
        deviceTurnOnCount--
        smartTv.turnOff()
    }

    fun increaseTvVolume() {
        smartTv.increaseVolume()
    }

    fun decreaseTvVolume() {
        smartTv.decreaseVolume()
    }

    fun changeChannelToNext() {
        smartTv.nextChannel()
    }

    fun changeChannelToPrevious() {
        smartTv.previousChannel()
    }

    fun turnOnLight() {
        deviceTurnOnCount++
        smartLight.turnOn()
    }

    fun turnOffLight() {
        deviceTurnOnCount--
        smartLight.turnOff()
    }

    fun increaseLightBrightness() {
        smartLight.increaseBrightness()
    }

    fun turnOffAllDevices() {
        smartTv.turnOff()
        smartLight.turnOff()
    }
}

class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {

    var fieldData = initialValue
    override fun getValue(thisRef: Any?, property: KProperty<*>): Int{
        return fieldData
    }
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int){
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}

fun main() {
    var smartDevice = SmartTV("Android Tv", "ONLINE")
    smartDevice.turnOn()
    smartDevice.printInfo()

    var smartDevice2 = SmartLight("Goggle Light")
    smartDevice.turnOn()


    println("\n ${smartDevice.deviceType}")
    var smartHOME = SmartHome(smartDevice, smartDevice2)
    smartHOME.turnOnTv()
}


// kotlinc file.kt -include-runtime -d file.jar
// java -jar file.jar