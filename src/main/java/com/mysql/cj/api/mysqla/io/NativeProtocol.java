/*
  Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.

  The MySQL Connector/J is licensed under the terms of the GPLv2
  <http://www.gnu.org/licenses/old-licenses/gpl-2.0.html>, like most MySQL Connectors.
  There are special exceptions to the terms and conditions of the GPLv2 as it is applied to
  this software, see the FOSS License Exception
  <http://www.mysql.com/about/legal/licensing/foss-exception.html>.

  This program is free software; you can redistribute it and/or modify it under the terms
  of the GNU General Public License as published by the Free Software Foundation; version 2
  of the License.

  This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
  See the GNU General Public License for more details.

  You should have received a copy of the GNU General Public License along with this
  program; if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth
  Floor, Boston, MA 02110-1301  USA

 */

package com.mysql.cj.api.mysqla.io;

import com.mysql.cj.api.io.Protocol;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import com.mysql.cj.core.exceptions.CJException;
import com.mysql.cj.mysqla.io.Buffer;

/**
 * Extends {@link Protocol} with methods specific to native MySQL protocol.
 *
 */
public interface NativeProtocol extends Protocol {

    void rejectProtocol(Buffer buf);

    PacketReader getPacketReader();

    /**
     * Read one packet from the MySQL server into the reusable Buffer if provided or into the new one.
     * 
     * @param reuse
     * @return the packet from the server.
     * 
     * @throws CJCommunicationsException
     */
    Buffer readPacket(Buffer reuse);

    /**
     * Read one packet from the MySQL server, checks for errors in it, and if none,
     * returns the packet, ready for reading
     * 
     * @return a packet ready for reading.
     * 
     * @throws CJException
     *             is the packet is an error packet
     */
    Buffer checkErrorPacket();

}
