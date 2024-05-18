# Sistema de Registro de Gastos

## Descripción
Este es un sistema desarrollado en Java que permite llevar un registro detallado de gastos por categoría, personal y en un período de tiempo específico. Facilita la gestión de gastos tanto para usuarios individuales como para equipos dentro de una organización.

## Modelo Conceptual de Datos
![CajaChica drawio (1)](https://github.com/erickzok/cajaContable/assets/121067321/5855eb83-a824-4d5a-8d1f-d92289ad8fda)



## Funcionalidades

1. **Dashboard Inicial:**
   - En la página de inicio, se presentan datos clave de manera visual y resumida para una rápida comprensión de la situación financiera:
     - **Gasto Mensual:** Muestra el gasto total del mes actual.
     - **Gasto Total:** Muestra el gasto acumulado desde el inicio del registro.
     - **Solicitudes Pendientes:** Lista las solicitudes de gastos por atender, realizadas por el personal. Estas solicitudes pueden ser aprobadas, rechazadas o pendientes de revisión.
![image](https://github.com/erickzok/cajaContable/assets/121067321/b4272107-749d-4a9e-905f-d1b268184a1c)



2. **Registro de Gastos:**
   - La página de registro permite al administrador ingresar directamente los gastos y algunos datos asociados a este
   - Los usuarios pueden detallar cada gasto con información adicional como descripción, monto .
![image](https://github.com/erickzok/cajaContable/assets/121067321/8b83b32c-5228-40c4-8560-065d85c2d1b2)


3. **Gestión de Solicitudes:**
   - Se proporciona una lista de todas las solicitudes de gastos realizadas por el personal, junto con su estado actual (pendiente, aprobada o rechazada).
   - Los usuarios con privilegios adecuados pueden revisar y procesar estas solicitudes de manera eficiente.
![image](https://github.com/erickzok/cajaContable/assets/121067321/38dc32ef-8684-4389-aaf8-389816af2791)


4. **Detalle de Solicitudes:**
   - Al hacer doble clic en cada solicitud de gasto en la lista de solicitudes, se abre una ventana emergente que muestra detalles adicionales, incluyendo:
     - Fecha de la solicitud.
     - Persona que realizó la solicitud.
     - Descripción detallada del gasto.
     - Estado actual de la solicitud.
     - Acciones disponibles para modificar el estado de la solicitud (aprobar, rechazar, etc.).
![image](https://github.com/erickzok/cajaContable/assets/121067321/9c73d603-1a68-439d-8f0f-9730ea627475)
![image](https://github.com/erickzok/cajaContable/assets/121067321/d8e9878c-2e81-4a9f-b0f6-9868984acec5)
![image](https://github.com/erickzok/cajaContable/assets/121067321/0c88f101-dff5-45e0-bc14-3716ec80be1d)

5. **Gráfico de Gastos por Tiempo:**
   - En esta sección, se presenta un gráfico interactivo que muestra la distribución de gastos a lo largo del tiempo.
   - Los gastos se agrupan por meses para identificar tendencias y patrones de gasto a lo largo del tiempo.
   - Los usuarios pueden ajustar el rango de tiempo para personalizar la visualización según sus necesidades.
![image](https://github.com/erickzok/cajaContable/assets/121067321/880ad1df-ded8-4140-9814-e7e624c410d1)
![image](https://github.com/erickzok/cajaContable/assets/121067321/ad53ebc5-2880-4d54-9644-ea3a424c0b70)


## Tecnologías Utilizadas
- Java
- javaswing
