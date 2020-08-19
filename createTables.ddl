--       Copyright 2017 IBM Corp All Rights Reserved

--   Licensed under the Apache License, Version 2.0 (the "License");
--   you may not use this file except in compliance with the License.
--   You may obtain a copy of the License at

--       http://www.apache.org/licenses/LICENSE-2.0

--   Unless required by applicable law or agreed to in writing, software
--   distributed under the License is distributed on an "AS IS" BASIS,
--   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
--   See the License for the specific language governing permissions and
--   limitations under the License.

--   Run this via "db2 -tf createTables.ddl"

CONNECT TO `BSU01-001`;

CREATE TABLE `Application` (
  `ID` bigint(20) NOT NULL,
  `Name` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `Description` longtext CHARACTER SET utf8 COLLATE utf8_bin NULL,
  `LogoUrl` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`ID`)
);

CREATE TABLE `Channel` (
  `ID` bigint(20) NOT NULL,
  `Name` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `Description` longtext CHARACTER SET utf8 COLLATE utf8_bin NULL,
  `IsActive` smallint(1) NOT NULL,
  PRIMARY KEY (`ID`)
);

CREATE TABLE `Msngruserprofile` (
  `Id` bigint(20) NOT NULL,
  `UserUniqueId` bigint(20) NOT NULL,
  `FisrtName` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `LastName` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `gender` varchar(20) NOT NULL,
  `locale` varchar(100) DEFAULT NULL,
  `profilePic` varchar(2000) DEFAULT NULL,
  `timeZone` int(11) DEFAULT NULL,
  `CreatedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `LastUpdatedDate` datetime DEFAULT NULL,
  `IsActive` smallint(1) NOT NULL,
  `appId` bigint(20) NOT NULL,
  `channelId` bigint(20) NOT NULL,
  PRIMARY KEY (`Id`)
);
CONNECT RESET;
