/*
 * Emoji Tools helps users and developers of Android, iOS, and OS X extract, modify, and repackage Emoji fonts.
 * Copyright (C) 2015 - 2016 Mitch Talmadge
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contact Mitch Talmadge at mitcht@liveforcode.net
 */

package net.liveforcode.emojitools.operations.packaging;

public class PackagingInfo {

    public static final int DEVICE_ANDROID = 0;
    public static final int DEVICE_IOS = 1;
    public static final int DEVICE_OSX = 2;
    private final int deviceToPackageFor;
    private short[] resolutions;

    public PackagingInfo(int deviceToPackageFor, short[] resolutions) {
        if (deviceToPackageFor < 0 || deviceToPackageFor > 2) {
            deviceToPackageFor = 0;
        }
        this.deviceToPackageFor = deviceToPackageFor;

        this.resolutions = resolutions;
    }

    public int getDeviceToPackageFor() {
        return deviceToPackageFor;
    }

    public short[] getResolutions() {
        return resolutions;
    }
}
