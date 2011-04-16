Major Components
-----------------

TimingModule
=============
+  INPUT: user gestures

+  OUTPUT: time

+  DESCRIPTION:  This component will be composed of a view with three buttons -- back, 
forward, play/pause -- and an on screen display of time.  The time will coorespond
to the time of video being coded. It will be the user's responsibility to keep the
time on the tablet in sync with the time on the video.  


EventController
================
+  INPUTS: user gestures, time

+  OUTPUT: data event

+  DESCRIPTION: This component will be composed of a view with an image of the device
being using in the study (such as a Kindle or a Digital Camera).  The view will 
have touch zones that coorespond to the buttons on the device in the image.

When the user touches one of the zones, this component will generate a data event that is composed
of the current time (received from the TimingModule) and the button cooresponding to the zone 
that was touched by the user.  

This component will include a listner interface, which will allow other components to receive the 
events it generates.

DataAggregator 
================
+  INPUT: data events

+  OUTPUT: data file

+  DESCRIPTION:  This component will contain a persistent store for the data collected by the 
application.  In will register itself as a listener of the EventController so that it can receive
data events.  Upon receiving events, it will append the data contained in the event to the 
persistence storage mechanism.  

This component will also contain a mechanism for performing the following actions on the persistent
store.  
    -  Clear all data
    -  Export all data (possible mechanisms include email, or transfer via usb)
    
    