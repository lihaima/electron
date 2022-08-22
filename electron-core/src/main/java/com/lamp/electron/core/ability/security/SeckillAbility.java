/*
 *Copyright (c) [Year] [name of copyright holder]
 *[Software Name] is licensed under Mulan PubL v2.
 *You can use this software according to the terms and conditions of the Mulan PubL v2.
 *You may obtain a copy of Mulan PubL v2 at:
 *         http://license.coscl.org.cn/MulanPubL-2.0
 *THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND,
 *EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT,
 *MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *See the Mulan PubL v2 for more details.
 */
package com.lamp.electron.core.ability.security;

import com.lamp.electron.base.common.ability.Seckill;
import com.lamp.electron.base.common.annotation.AbiltiyAction;
import com.lamp.electron.base.common.enums.AbilityType;
import com.lamp.electron.base.common.invoker.ElectronRequest;
import com.lamp.electron.base.common.invoker.ElectronResponse;
import com.lamp.electron.base.common.invoker.Invoker;
import com.lamp.electron.core.ability.AbstractChainAbility;
import com.lamp.electron.core.ability.extend.ResultAbility;

@AbiltiyAction(abilityType = AbilityType.SECKILL)
public class SeckillAbility extends AbstractChainAbility<Seckill> implements ResultAbility {

	@Override
	public ElectronResponse run(ElectronRequest electronRequest, ElectronResponse electronResponse, Invoker invoker) {
		// 去redis 减一 ，如果返回 大于0 ，就可以，小鱼0就失败
		return null;
	}

	@Override
	public ElectronResponse result(ElectronRequest electronRequest, ElectronResponse electronResponse,
			Invoker invoker) {
		return null;
	}

}
