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
![image](https://github.com/erickzok/cajaContable/assets/121067321/23846642-e408-49e9-b811-10e73094efdf)

2. **Registro de Gastos:**
   - La página de registro permite a los usuarios ingresar directamente los gastos por persona, categoría y fecha.
   - Los usuarios pueden detallar cada gasto con información adicional como descripción, monto y método de pago.
![image](https://github.com/erickzok/cajaContable/assets/121067321/4f159013-9d71-4588-98df-8e3842e4072a)

3. **Gestión de Solicitudes:**
   - Se proporciona una lista de todas las solicitudes de gastos realizadas por el personal, junto con su estado actual (pendiente, aprobada o rechazada).
   - Los usuarios con privilegios adecuados pueden revisar y procesar estas solicitudes de manera eficiente.
![image](https://github.com/erickzok/cajaContable/assets/121067321/006509bd-c4ae-430a-a69e-7d6c23ef9841)

4. **Detalle de Solicitudes:**
   - Al hacer doble clic en cada solicitud de gasto en la lista de solicitudes, se abre una ventana emergente que muestra detalles adicionales, incluyendo:
     - Fecha de la solicitud.
     - Persona que realizó la solicitud.
     - Descripción detallada del gasto.
     - Estado actual de la solicitud.
     - Acciones disponibles para modificar el estado de la solicitud (aprobar, rechazar, etc.).

5. **Gráfico de Gastos por Tiempo:**
   - En esta sección, se presenta un gráfico interactivo que muestra la distribución de gastos a lo largo del tiempo.
   - Los gastos se agrupan por meses para identificar tendencias y patrones de gasto a lo largo del tiempo.
   - Los usuarios pueden ajustar el rango de tiempo para personalizar la visualización según sus necesidades.
![image](https://github.com/erickzok/cajaContable/assets/121067321/46fe03a4-dd8e-4726-a098-851fccd10506)
![image](https://github.com/erickzok/cajaContable/assets/121067321/c095b05b-f2ce-4dc3-b27a-c255c127e691)

## Tecnologías Utilizadas
- Java
- javaswing
