# Acta de Constatación

## Descripción
Proyecto Spring Boot para manejar actas de constatación con Thymeleaf, JPA y MySQL. El sistema permite crear, consultar y gestionar actas de constatación de infracciones viales con registro de vehículos, conductores, autoridades, infracciones y estados.


## Requisitos
- Java 17
- Maven (se incluye `mvnw` / `mvnw.cmd`)
- MySQL corriendo en `localhost:3306`

## Configuración de la base de datos
**Importante**: Es fundamental seguir este orden exacto para evitar inconvenientes:

### 1. Crear solo la base de datos (sin tablas)
Ejecuta en MySQL:
```sql
CREATE DATABASE actas;
```

### 2. Arranca el proyecto (genera las tablas automáticamente)
Desde la raíz del proyecto ejecuta:

Windows:
```powershell
./mvnw.cmd clean spring-boot:run
```

Linux/macOS:
```bash
./mvnw clean spring-boot:run
```

Déjalo corriendo hasta que veas `Tomcat started on port(s): 8080` en la consola. **Esto es importante**: Hibernate creará automáticamente todas las tablas usando la configuración `spring.jpa.hibernate.ddl-auto=update` en `application.properties`.

### 3. Una vez que las tablas están creadas, inserta los datos iniciales

**ATENCIÓN**
 LO QUE HICE PARA INSERTAR LOS DATOS Y QUE NO ME FALLE FUE QUE SELECCIONE CON EL MOUSE TODOS LOS INSERT Y EJECUTE CON EL PRIMER RAYO LUEGO DE SEGUIR LOS PASOS.

En MySQL, ejecuta:
```sql
USE actas;
```

Luego inserta los datos:
```sql
INSERT INTO estados_acta (id_estado, descripcion_estado, nombre_estado) VALUES
(1, 'Acta generada y pendiente de pago', 'GENERADA'),
(2, 'Acta pagada', 'PAGADA'),
(3, 'Acta anulada', 'ANULADA');

INSERT INTO marcas (id_marca, marca_auto) VALUES
(1, 'Toyota'),
(2, 'Ford'),
(3, 'Chevrolet');

INSERT INTO vehiculos (id_vehiculo, color, dominio, anio_patentamiento, marca_id) VALUES
(1, 'Blanco', 'ABC123', 2019, 1),
(2, 'Rojo', 'DEF456', 2021, 2),
(3, 'Azul', 'GHI789', 2018, 3);

INSERT INTO personas (id_persona, nombre, apellido, dni, genero, tipo_persona) VALUES
(1, 'Miguel', 'Sánchez', 38123456, 'Masculino', 'CONDUCTOR'),
(2, 'Lucía', 'Torres', 39123457, 'Femenino', 'AUTORIDAD'),
(3, 'Carlos', 'Pérez', 38111222, 'Masculino', 'CONDUCTOR');

INSERT INTO conductores (id_persona, domicilio) VALUES
(1, 'Av. Siempre Viva 742'),
(3, 'Calle Falsa 123');

INSERT INTO licencias (id_licencia, fecha_vto, puntos_licencias, conductor_id) VALUES
(101, '2026-12-31', 30, 1),
(102, '2027-06-30', 25, 3);

INSERT INTO autoridades_constatacion (id_persona, id_placa, id_legajo) VALUES
(2, 5555, 7890);

INSERT INTO organizaciones_estatales (id_organizacion, nombre_organizacion, localidad) VALUES
(1, 'Dirección Nacional de Vialidad', 'Buenos Aires'),
(2, 'Policía Caminera', 'Santa Fe');

INSERT INTO tipos_ruta (id_tipo_ruta, descripcion_tipo_ruta, nombre_tipo_ruta) VALUES
(1, 'Ruta nacional pavimentada', 'Nacional'),
(2, 'Ruta provincial sin pavimentar', 'Provincial');

INSERT INTO rutas (id_ruta, nombre_ruta, km_ruta, tipo_ruta_id) VALUES
(1, 'Ruta 7', '120', 1),
(2, 'Ruta 11', '45', 2);

INSERT INTO tipos_infraccion (id_infrac, descripcion_infraccion, tipo_gravedad, importe_asignado, porcentaje_descuento) VALUES
(1, 'Exceso de velocidad en zona urbana', 'Media', 150.00, 0.00),
(2, 'No respetar semáforo en rojo', 'Alta', 300.00, 0.00),
(3, 'Estacionar en zona prohibida', 'Baja', 80.00, 0.00),
(4, 'Circular sin casco', 'Alta', 250.00, 0.00);
```

> **Nota**: Si obtienes errores de duplicados, borra los datos (`DELETE FROM ...`) antes de reintentar. Si necesitas reiniciar desde cero, ejecuta el script nuevamente.

## Configuración de conexión
La aplicación lee la conexión desde `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/actas?createDatabaseIfNotExist=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

Si tu usuario o contraseña son diferentes, modificalos en ese archivo.

## Cómo arrancar el proyecto
Desde la raíz del proyecto ejecuta:

Windows:
```powershell
./mvnw.cmd clean spring-boot:run
```

Linux/macOS:
```bash
./mvnw clean spring-boot:run
```

## Qué probar
- Abre `http://localhost:8080/menu`
- Crea una nueva acta en `/actas/nueva` (verás todos los campos disponibles una vez insertados los datos)
- Consulta actas en `/actas/consulta`

## Observaciones
- El proyecto está configurado para Java 17.
- Si usás MySQL con contraseña, actualiza `spring.datasource.password`.
- El servidor embebido corre en el puerto `8080`.
- Las tablas se crean automáticamente en el primer arranque gracias a Hibernate.
- Los datos iniciales deben insertarse **después** de que el proyecto haya creado las tablas.
