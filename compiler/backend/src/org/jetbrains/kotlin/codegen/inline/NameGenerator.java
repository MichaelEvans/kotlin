/*
 * Copyright 2010-2015 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.codegen.inline;

import java.util.HashMap;
import java.util.Map;

public class NameGenerator {

    private final String ownerMethod;

    private int nextLambdaIndex = 1;
    private int nextWhenIndex = 1;

    private final Map<String, NameGenerator> subGenerators = new HashMap<String, NameGenerator>();

    public NameGenerator(String onwerMethod) {
        this.ownerMethod = onwerMethod;
    }

    public String genLambdaClassName() {
        return ownerMethod + "$" + nextLambdaIndex++;
    }

    public String genWhenClassNamePrefix() {
        return ownerMethod + "$" + nextWhenIndex++;
    }

    public NameGenerator subGenerator(String inliningMethod) {
        NameGenerator generator = subGenerators.get(inliningMethod);
        if (generator == null) {
            generator = new NameGenerator(ownerMethod+ "$" + inliningMethod);
            subGenerators.put(inliningMethod, generator);
        }
        return generator;
    }
}
