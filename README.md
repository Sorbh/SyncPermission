# Sync Permission
sync-permission is the easiest way to manage Android Marshmallow and Nougat runtime permissions from activity or non-activity context.

![open source](https://img.shields.io/badge/Open%20source-free-green.svg?longCache=true&style=flat-square)
![build number](https://img.shields.io/badge/Build-passing-green.svg?longCache=true&style=flat-square)
![version number](https://img.shields.io/badge/Download-1.0.0-blue.svg?longCache=true&style=flat-square)
![Size](https://img.shields.io/badge/Size-9KB-blue.svg?longCache=true&style=flat-square)
![Method count](https://img.shields.io/badge/Method%20count-25k-red.svg?longCache=true&style=flat-square)
![License Apache](https://img.shields.io/badge/License-apache%202.0-red.svg?longCache=true&style=flat-square)


![alt text](https://github.com/sorbh/sync-permission/blob/master/raw/demo.gif)


# Motivation

Implementing runtime permissions forces the developer to add the code for granting (and checking if the permission has already been granted) in their Activities. At a time when everybody is trying to make their Activity classes lighter (with the help of Architecture Components by Google itself), this adds lots of boilerplate code in our activity.

So I intend to solve this by using a separate module which handles all the runtime permission hassle and implement runtime permission in less code and sync manner.

So this library handles all the permission handling logic.Even you can use it from non-activity context.

# Getting started

## Installing
To use this library simply import it by placing the following line under dependencies in your app module's build.gradle file

This library is posted in jCenter

#### Gradle
```Gradle
implementation 'in.unicodelabs.sorbh:sync-permission:1.0.0'
```

#### Maven
```Gradle
<dependency>
  <groupId>in.unicodelabs.sorbh</groupId>
  <artifactId>sync-permission</artifactId>
  <version>1.0.0</version>
  <type>pom</type>
</dependency>
```

# Usage

if you want to ask single or multiple permission requests, you just need to create GetPermission builder, setPermission to it and enqueue the callback.
the same call back works for both single or multiple requests.

```Java
new SyncPermission.Builder(context).setPermissions(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.RECORD_AUDIO).enqueue(new PermissionResultCallback() {
                    @Override
                    public void onPermissionGranted(ArrayList<PermissionRequest> grantedPermission) {
                        for (PermissionRequest permissionRequest : grantedPermission) {
                            Log.d("Get Permission", "Granted - " + permissionRequest.getPermission());
                        }
                    }

                    @Override
                    public void onPermissionDenied(ArrayList<PermissionRequest> deniedPermission, final PermissionDeniedDelegate permissionDeniedDelegate) {
                        for (final PermissionRequest permissionRequest : deniedPermission) {
                            Log.d("Get Permission", "Denied - " + permissionRequest.getPermission());

                            //Once user denied permission with never asked, show waring message to user and call this on
                            //postive response to open the setting screen
                            //if (permissionRequest.isPermanentlyDenied())
                            //    permissionDeniedDelegate.openSetting();
                        }
                    }

                    @Override
                    public void onPermissionRationalShouldShow(final ArrayList<PermissionRequest> rationalPermission, final PermissionRationalDelegate permissionRationalDelegate) {
                        for (final PermissionRequest permissionRequest : rationalPermission) {
                            Log.d("Get Permission", "Rational - " + permissionRequest.getPermission());

                            //Call this on positive response on rational dialog
                            //permissionRationalDelegate.requestPermission(permissionRequest, 110);
                        }
                    }
                });
```

  * ```Java permissionRationalDelegate.requestPermission(permissionRequest, 110) ``` Show user Ration dialog on rational call back and on positive response call this method to ask permission again.
  * ```Java permissionDeniedDelegate.openSetting() ``` in case user check the never asked and denied the permission, you can show user warning message and force the user to allow permission in setting by opening setting screen for the application.


# Screenshots
![alt text](https://github.com/sorbh/sync-permission/blob/master/raw/1.jpeg)

# Author
  * **Saurabh K Sharma - [GIT](https://github.com/Sorbh)**

      I am very new to open source community. All suggestion and improvement are most welcomed.


## Contributing

1. Fork it (<https://github.com/sorbh/sync-permission/fork>)
2. Create your feature branch (`git checkout -b feature/fooBar`)
3. Commit your changes (`git commit -am 'Add some fooBar'`)
4. Push to the branch (`git push origin feature/fooBar`)
5. Create a new Pull Request


# License

```
Copyright 2018 Saurabh Kumar Sharma

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
