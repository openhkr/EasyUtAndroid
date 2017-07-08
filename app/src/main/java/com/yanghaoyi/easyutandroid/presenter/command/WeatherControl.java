package com.yanghaoyi.easyutandroid.presenter.command;

import com.yanghaoyi.easyutandroid.view.IWeatherView;

/**
 * Author : YangHaoyi on 2017/5/31.
 * Email  :  yanghaoyi@neusoft.com
 * Description :命令模式控制器
 * Change : YangHaoYi on 2017/6/7.
 * Version : V 1.0
 */

public class WeatherControl {

    public static final int TEMPERATURE = 0;
    public static final int PRECIPITATION = 1;
    public static final int WINDPOWER = 2;
    private static final int COMMAND_COUNT = 3;


    private WeatherCommand[] weatherCommands;


    public WeatherControl(IWeatherView view) {
        weatherCommands = new WeatherCommand[COMMAND_COUNT];
        weatherCommands[TEMPERATURE] = new TemperatureCommand(view);
        weatherCommands[PRECIPITATION] = new PrecipitationCommand(view);
        weatherCommands[WINDPOWER] = new WindPowerCommand(view);
    }

    public void buttonWasPressed(int solt){
        weatherCommands[solt].execute();
    }
}
