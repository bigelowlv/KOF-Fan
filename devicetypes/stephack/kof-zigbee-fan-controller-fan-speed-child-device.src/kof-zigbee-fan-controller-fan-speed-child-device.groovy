/**
 *  King Of Fans Zigbee Fan Controller - Fan Speed Child Device
 *
 *  Copyright 2017 Stephan Hackett
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */
def version() {return "v0.2.1.20170430"}

metadata {
	definition (name: "KOF Zigbee Fan Controller - Fan Speed Child Device", namespace: "stephack", author: "Stephan Hackett") {
		capability "Actuator"
        capability "Switch"
        capability "Light"
        capability "Sensor"
        
        attribute "fanSpeed", "string"
        
   }
   
   tiles(scale: 2) {
		//standardTile("switch", "switch", width: 2, height: 2) {
     		//state "off", label:"off", action: "on", icon: getIcon(), backgroundColor: "#ffffff", nextState: "turningOn"
			//state "on", label: "on", action: "off", icon: getIcon(), backgroundColor: "#79b821", nextState: "turningOff"
        	//state "turningOn", label:"ADJUSTING", action: "on", icon: getIcon(), backgroundColor: "#2179b8", nextState: "turningOn"
           // state "turningOff", label:"TURNING OFF", action:"off", icon: getIcon(), backgroundColor:"#2179b8", nextState: "turningOff"
		//}
        standardTile("fanSpeed", "fanSpeed", width: 2, height: 2) {
     		//state "off", label:"off", action: "on", icon: "https://cdn.rawgit.com/stephack/KOF-Fan/master/resources/images/fanspeed00.png", backgroundColor: "#ffffff", nextState: "turningOn"
			//state "default", label: "ADJUSTING", action: "on", icon: "https://cdn.rawgit.com/stephack/KOF-Fan/master/resources/images/fanspeed04.png", backgroundColor: "#2179b8"
            state "on01", label: "LOW", action: "off", icon: getIcon()+"fan1h.png", backgroundColor: "#79b821", nextState: "turningOff"
           	state "on02", label: "MED", action: "off", icon: getIcon()+"fan2h.png", backgroundColor: "#79b821", nextState: "turningOff"
			state "on03", label: "MED-HI", action: "off", icon: getIcon()+"fan3h.png", backgroundColor: "#79b821", nextState: "turningOff"
			state "on04", label: "HIGH", action: "off", icon: getIcon()+"fan4h.png", backgroundColor: "#79b821", nextState: "turningOff"
			state "on06", label: "BREEZE", action: "off", icon: getIcon()+"breeze4h_teal.png", backgroundColor: "#79b821", nextState: "turningOff"
			state "off01", label: "PUSH", action: "on", icon: getIcon()+"fan1h_grey.png", backgroundColor: "#ffffff", nextState: "turningOn"
           	state "off02", label: "PUSH", action: "on", icon: getIcon()+"fan2h_grey.png", backgroundColor: "#ffffff", nextState: "turningOn"
			state "off03", label: "PUSH", action: "on", icon: getIcon()+"fan3h_grey.png", backgroundColor: "#ffffff", nextState: "turningOn"
			state "off04", label: "PUSH", action: "on", icon: getIcon()+"fan4h_grey.png", backgroundColor: "#ffffff", nextState: "turningOn"
			state "off06", label: "PUSH", action: "on", icon: getIcon()+"breeze4h_grey.png", backgroundColor: "#ffffff", nextState: "turningOn"
        	state "turningOn", label:"ADJUSTING", action: "on", icon: getIcon()+"fan0h.png", backgroundColor: "#2179b8", nextState: "turningOn"
            state "turningOff", label:"TURNING OFF", action:"off", icon: getIcon()+"fan0h.png", backgroundColor:"#2179b8", nextState: "turningOff"
		}
    
    	main(["fanSpeed"])        
		details(["fanSpeed"])    
    
	}
}

def getIcon() {
	return "https://cdn.rawgit.com/dcoffing/KOF-CeilingFan/master/resources/images/"
    //return "https://cdn.rawgit.com/stephack/KOF-Fan/master/resources/images/fanspeed0"
}

def off() {
	parent.off()  
}

def on() {
	log.info "CHILD ${getDataValue('speedVal')} TURNED ON"    
    parent.setFanSpeed(getDataValue("speedVal"))
}
