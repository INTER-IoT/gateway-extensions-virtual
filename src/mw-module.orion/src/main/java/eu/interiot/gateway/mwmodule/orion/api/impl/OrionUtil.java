/*
 * Copyright 2016-2018 Universitat Politècnica de València
 * Copyright 2016-2018 Università della Calabria
 * Copyright 2016-2018 Prodevelop, SL
 * Copyright 2016-2018 Technische Universiteit Eindhoven
 * Copyright 2016-2018 Fundación de la Comunidad Valenciana para la
 * Investigación, Promoción y Estudios Comerciales de Valenciaport
 * Copyright 2016-2018 Rinicom Ltd
 * Copyright 2016-2018 Association pour le développement de la formation
 * professionnelle dans le transport
 * Copyright 2016-2018 Noatum Ports Valenciana, S.A.U.
 * Copyright 2016-2018 XLAB razvoj programske opreme in svetovanje d.o.o.
 * Copyright 2016-2018 Systems Research Institute Polish Academy of Sciences
 * Copyright 2016-2018 Azienda Sanitaria Locale TO5
 * Copyright 2016-2018 Alessandro Bassi Consulting SARL
 * Copyright 2016-2018 Neways Technologies B.V.
 *
 * See the NOTICE file distributed with this work for additional information
 * regarding copyright ownership.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eu.interiot.gateway.mwmodule.orion.api.impl;

import org.osgi.framework.BundleContext;

import eu.interiot.gateway.commons.api.device.DeviceDefinition;
import eu.interiot.gateway.commons.api.gateway.GatewayInfo;
import eu.interiot.gateway.commons.virtual.api.remote.PhysicalRemoteGatewayService;

public class OrionUtil {
	
	// private static ConfigurationService configurationService;
	// private static String gatewayUuid = "default";
	// private static HashMap<String, String> entityToDevice = new HashMap<>();
	
	private static PhysicalRemoteGatewayService physicalGateway;
	
	public static void configure(BundleContext context) {
		// OrionUtil.configurationService = context.getService(context.getServiceReference(ConfigurationService.class));
		OrionUtil.physicalGateway = context.getService(context.getServiceReference(PhysicalRemoteGatewayService.class));
	}
	
	public static String getEntityId(String deviceId) {
		return deviceId;
		/*
		if(OrionUtil.gatewayUuid.equals("default")) {
			OrionUtil.gatewayUuid = configurationService.get("gateway.uuid", "default");
		}
		String orionDeviceId = "gw-" + OrionUtil.gatewayUuid + "-" + deviceId;
		OrionUtil.entityToDevice.put(orionDeviceId, deviceId);
		return orionDeviceId;*/
	}
	
	public static String getEntityType(DeviceDefinition device) {
		return device.getType();
	}
	
	public static String getDeviceId(String entityId) {
		return entityId;
		// return entityToDevice.get(entityId);
	}
	
	public static String getFiwareServicePath() {
		GatewayInfo info = OrionUtil.physicalGateway.getRemoteInfo();
		return info == null ? "/gateway" : "/" + info.getUUID().replaceAll("-", "");
	}
}
