import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinAnalogInput;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.wiringpi.GpioUtil;

public class Example{
    final GpioPinDigitalInput pinHXDAT;
    final GpioPinDigitalOutput pinHXCLK;
    final HX711 hx;

    public Example(){
        GpioUtil.enableNonPrivilegedAccess();

        gpio = GpioFactory.getInstance();
        pinHXDAT = gpio.provisionDigitalInputPin(RaspiPin.GPIO_15, "HX_DAT", PinPullResistance.OFF);
        pinHXCLK = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_16, "HX_CLK", PinState.LOW);

        hx = new HX711(pinHXDAT, pinHXCLK, 128);

        hx.read();
        System.out.println(hx.value);
        System.out.println(hx.weight);        
    }
}