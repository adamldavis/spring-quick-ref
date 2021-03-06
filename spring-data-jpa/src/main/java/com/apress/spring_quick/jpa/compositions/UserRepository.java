/*
 * Copyright 2017-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.apress.spring_quick.jpa.compositions;

import org.springframework.data.repository.CrudRepository;

/**
 * Composite repository implementing a default {@link CrudRepository} extended with {@link ContactRepository},
 * {@link EmployeeRepository}, and {@link FlushOnSaveRepository} fragments.
 *
 * @author Mark Paluch
 */
public interface UserRepository
		extends CrudRepository<User, Long>, ContactRepository, EmployeeRepository, FlushOnSaveRepository<User> {}
